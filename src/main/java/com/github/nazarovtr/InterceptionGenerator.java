package com.github.nazarovtr;

import java.util.Set;

public class InterceptionGenerator {
    public static void main(String[] args) {
        boolean blue = false;
        boolean generateConditionals = false;
        int objectiveId = 324;
        int orderId = 108;
        Set<Integer> skipWaypointIds = Set.of(4, 11, 16, 21, 29, 33);
        int[] amounts = new int[] {8, 13, 8, 8, 11, 10, 11, 8, 8, 13, 8};
        int[] startingWaypointIds = !blue ? new int[] {106, 72, 56, 40, 14, 2, 27, 48, 64, 85, 98} : new int[] {98, 85, 64, 48, 27, 2, 14, 40, 56, 72, 106};
        String team = !blue ? "blue" : "red";
        int conditionalId = 109;
        for (int j = 0; j < amounts.length; j++) {
            int amount = amounts[j];
            int waypointId = startingWaypointIds[j];
            int number = j + 1;
            char letter = 'a';
            for (int i = 1; i <= amount; i++) {
                if (! generateConditionals) {
                    System.out.println(
                            "\t\tObjective\n" +
                                    "\t\t{\n" +
                                    "\t\t\tobjectiveName = Intercept " + team + " " + number + letter + "\n" +
                                    "\t\t\tobjectiveInfo = Delay the opposing team delivery by intercepting their helicopters.\n" +
                                    "\t\t\tobjectiveID = " + objectiveId + "\n" +
                                    "\t\t\torderID = " + orderId + "\n" +
                                    "\t\t\trequired = False\n" +
                                    "\t\t\tcompletionReward = 0\n" +
                                    "\t\t\twaypoint = " + waypointId + "\n" +
                                    "\t\t\tautoSetWaypoint = False\n" +
                                    "\t\t\tstartMode = Triggered\n" +
                                    "\t\t\tobjectiveType = Conditional\n" +
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
                                    "\t\t\t\t}\n" +
                                    "\t\t\t}\n" +
                                    "\t\t\tfields\n" +
                                    "\t\t\t{\n" +
                                    "\t\t\t\tsuccessConditional = null\n" +
                                    "\t\t\t\tfailConditional = " + conditionalId + "\n" +
                                    "\t\t\t}\n" +
                                    "\t\t}"
                    );
                }
                if (generateConditionals) {
                    System.out.println(
                            "\t\tCONDITIONAL\n" +
                                    "\t\t{\n" +
                                    "\t\t\tid = " + conditionalId + "\n" +
                                    "\t\t\toutputNodePos = (0, 0, 0)\n" +
                                    "\t\t\troot = 0\n" +
                                    "\t\t\tCOMP\n" +
                                    "\t\t\t{\n" +
                                    "\t\t\t\tid = 0\n" +
                                    "\t\t\t\ttype = SCCGlobalValue\n" +
                                    "\t\t\t\tuiPos = (-285, 44, 0)\n" +
                                    "\t\t\t\tgv = " + (blue ? 1 : 0) +"\n" +
                                    "\t\t\t\tcomparison = Greater_Than\n" +
                                    "\t\t\t\tc_value = " + number + "\n" +
                                    "\t\t\t}\n" +
                                    "\t\t}"
                    );
                }
                letter++;
                objectiveId++;
                orderId++;
                waypointId++;
                conditionalId++;
                while (skipWaypointIds.contains(waypointId)) {
                    waypointId++;
                }
            }
        }
        System.out.println(objectiveId);
        System.out.println(orderId);
    }
}
