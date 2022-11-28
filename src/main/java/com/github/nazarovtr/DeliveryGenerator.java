package com.github.nazarovtr;

import java.util.Set;

public class DeliveryGenerator {
    public static void main(String[] args) {
        boolean blue = false;
        int objectiveId = 112;
        int orderId = 2;
        Set<Integer> skipWaypointIds = Set.of(4, 11, 16, 21, 29, 33);
        int[] amounts = new int[] {8, 13, 8, 8, 11, 10, 11, 8, 8, 13, 8};
        int[] startingWaypointIds = blue ? new int[] {106, 72, 56, 40, 14, 2, 27, 48, 64, 85, 98} : new int[] {98, 85, 64, 48, 27, 2, 14, 40, 56, 72, 106};
        String team = blue ? "Blue" : "Red";
        int scoreObjectiveId = blue ? 2 : 5;
        for (int j = 0; j < amounts.length; j++) {
            int amount = amounts[j];
            int waypointId = startingWaypointIds[j];
            int number = j + 1;
            int reward = j * 50 + 100;
            char letter = 'a';
            for (int i = 1; i <= amount; i++) {
                System.out.println(
                        "\t\tObjective\n" +
                                "\t\t{\n" +
                                "\t\t\tobjectiveName = " + team + " delivery " + number + letter +"\n" +
                                "\t\t\tobjectiveInfo = Land at the waypoint to complete a delivery.\n" +
                                "\t\t\tobjectiveID = " + objectiveId + "\n" +
                                "\t\t\torderID = " + orderId + "\n" +
                                "\t\t\trequired = False\n" +
                                "\t\t\tcompletionReward = " + reward + "\n" +
                                "\t\t\twaypoint = " + waypointId + "\n" +
                                "\t\t\tautoSetWaypoint = True\n" +
                                "\t\t\tstartMode = Triggered\n" +
                                "\t\t\tobjectiveType = Land\n" +
                                "\t\t\tstartEvent\n" +
                                "\t\t\t{\n" +
                                "\t\t\t\tEventInfo\n" +
                                "\t\t\t\t{\n" +
                                "\t\t\t\t\teventName = Start Event\n" +
                                "\t\t\t\t}\n" +
                                "\t\t\t}\n" +
                                "\t\t\tfailEvent\n" +
                                "\t\t\t{\n" +
                                "\t\t\t\tEventInfo\n" +
                                "\t\t\t\t{\n" +
                                "\t\t\t\t\teventName = Failed Event\n" +
                                "\t\t\t\t}\n" +
                                "\t\t\t}\n" +
                                "\t\t\tcompleteEvent\n" +
                                "\t\t\t{\n" +
                                "\t\t\t\tEventInfo\n" +
                                "\t\t\t\t{\n" +
                                "\t\t\t\t\teventName = Completed Event\n" +
                                "\t\t\t\t\tEventTarget\n" +
                                "\t\t\t\t\t{\n" +
                                "\t\t\t\t\t\ttargetType = Objective\n" +
                                "\t\t\t\t\t\ttargetID = " + scoreObjectiveId + "\n" +
                                "\t\t\t\t\t\teventName = Begin Objective\n" +
                                "\t\t\t\t\t\tmethodName = BeginObjective\n" +
                                "\t\t\t\t\t}\n" +
                                "\t\t\t\t}\n" +
                                "\t\t\t}\n" +
                                "\t\t\tfields\n" +
                                "\t\t\t{\n" +
                                "\t\t\t\tradius = 5\n" +
                                "\t\t\t}\n" +
                                "\t\t}");
                letter++;
                objectiveId++;
                orderId++;
                waypointId++;
                while (skipWaypointIds.contains(waypointId)) {
                    waypointId++;
                }
            }
        }
        System.out.println(objectiveId);
        System.out.println(orderId);
    }
}
