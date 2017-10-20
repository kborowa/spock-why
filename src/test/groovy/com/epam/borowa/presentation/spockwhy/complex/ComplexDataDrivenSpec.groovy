package com.epam.borowa.presentation.spockwhy.complex

import org.cloudfoundry.uaa.groups.GroupEntity
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Clock
import java.time.Instant
import java.time.ZoneId

class ComplexDataDrivenSpec extends Specification {

    private static final Instant STARTED_EVENT_DATE = Instant.parse("2017-01-08T08:00:00.00Z");
    private static final Instant NOW = Instant.parse("2017-01-10T10:00:00.00Z");
    private static final Instant NOT_STARTED_EVENT_DATE = Instant.parse("2017-01-11T11:00:00.00Z");

    private final ActiveGroupFilter groupFilter = new ActiveGroupFilter(Clock.fixed(NOW, ZoneId.of("UTC")));

    @Unroll
    def "(#no) Number of competitions should be #howManySubgroupsRemain when filtering region where competition = (oneOfMarketIsBlocked: #blockedMarket, oneOfMarketIsOpen #openMarket, startedAt: #startedAt, endedAt: #endedAt, eventType: #eventType) "() {
        given:
        final GroupEntity regionGroupGraph = aGermanRegionGroup()
                .withSubGroup(
                aBundesligaCompetitionGroup()
                        .withEvent(anEvent()
                            .withAtLeastOneBetMarketBlocked(blockedMarket)
                            .withAtLeastOneBetMarketOpen(openMarket)
                            .withStartsAt(startedAt)
                            .withEventType(eventType)
                            .build())
                        .build())
                .build()

        when:
        groupFilter.removeNonActiveGroups(regionGroupGraph)

        then:
        regionGroupGraph.getSubGroups().size() == expectedNumberOfSubgroups

        where:
        no | blockedMarket | openMarket | startedAt              | eventType || expectedNumberOfSubgroups
        1  | true          | true       | NOT_STARTED_EVENT_DATE | PREMATCH  || 1
        2  | false         | true       | NOT_STARTED_EVENT_DATE | PREMATCH  || 1
        3  | true          | false      | NOT_STARTED_EVENT_DATE | PREMATCH  || 0
        4  | false         | false      | NOT_STARTED_EVENT_DATE | PREMATCH  || 0
        5  | true          | true       | STARTED_EVENT_DATE     | PREMATCH  || 0
        6  | false         | true       | STARTED_EVENT_DATE     | PREMATCH  || 0
        7  | true          | false      | STARTED_EVENT_DATE     | PREMATCH  || 0
        8  | false         | false      | STARTED_EVENT_DATE     | PREMATCH  || 0
        9  | true          | true       | NOT_STARTED_EVENT_DATE | LIVE      || 1
        10 | false         | true       | NOT_STARTED_EVENT_DATE | LIVE      || 1
        11 | true          | false      | NOT_STARTED_EVENT_DATE | LIVE      || 0
        12 | false         | false      | NOT_STARTED_EVENT_DATE | LIVE      || 0
        13 | true          | true       | STARTED_EVENT_DATE     | LIVE      || 1
        14 | false         | true       | STARTED_EVENT_DATE     | LIVE      || 1
        15 | true          | false      | STARTED_EVENT_DATE     | LIVE      || 1
        16 | false         | false      | STARTED_EVENT_DATE     | LIVE      || 0
        17 | true          | true       | NOT_STARTED_EVENT_DATE | HALFTIME  || 1
        18 | false         | true       | NOT_STARTED_EVENT_DATE | HALFTIME  || 1
        19 | true          | false      | NOT_STARTED_EVENT_DATE | HALFTIME  || 0
        20 | false         | false      | NOT_STARTED_EVENT_DATE | HALFTIME  || 0
        21 | true          | true       | STARTED_EVENT_DATE     | HALFTIME  || 1
        22 | false         | true       | STARTED_EVENT_DATE     | HALFTIME  || 1
        23 | true          | false      | STARTED_EVENT_DATE     | HALFTIME  || 1
        24 | false         | false      | STARTED_EVENT_DATE     | HALFTIME  || 0
        25 | false         | false      | STARTED_EVENT_DATE     | HALFTIME  || 0

    }
}
