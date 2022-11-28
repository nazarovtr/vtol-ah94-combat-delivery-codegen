package com.github.nazarovtr;

import java.util.Set;

public class RandomTriggerGenerator {
    public static void main(String[] args) {
        boolean blue = false;
        boolean generateConditionals = false;
        boolean generateConditionalAction = false;
        int objectiveId = 112;
        int orderId = 108;
        int[] amounts = new int[] {8, 13, 8, 8, 11, 10, 11, 8, 8, 13, 8};
        String team = blue ? "blue" : "red";
        int objectiveIdDiff = 106;
        int conditionalId = 226;
        int conditionalActionId = 115;
        int triggerId = 11;
        for (int j = 0; j < amounts.length; j++) {
            int amount = amounts[j];
            int number = j + 1;
            if (!generateConditionals && !generateConditionalAction) {
                System.out.println(
                        "\t\tTriggerEvent\n" +
                                "\t\t{\n" +
                                "\t\t\tid = " + triggerId + "\n" +
                                "\t\t\tenabled = True\n" +
                                "\t\t\ttriggerType = Conditional\n" +
                                "\t\t\tconditional = " + conditionalId + "\n" +
                                "\t\t\teventName = start_" + team + "_" + number + "\n" +
                                "\t\t\tEventInfo\n" +
                                "\t\t\t{\n" +
                                "\t\t\t\teventName = \n" +
                                "\t\t\t\tEventTarget\n" +
                                "\t\t\t\t{\n" +
                                "\t\t\t\t\ttargetType = System\n" +
                                "\t\t\t\t\ttargetID = 0\n" +
                                "\t\t\t\t\teventName = Fire Conditional Action\n" +
                                "\t\t\t\t\tmethodName = FireConditionalAction\n" +
                                "\t\t\t\t\tParamInfo\n" +
                                "\t\t\t\t\t{\n" +
                                "\t\t\t\t\t\ttype = ConditionalActionReference\n" +
                                "\t\t\t\t\t\tvalue = " + conditionalActionId + "\n" +
                                "\t\t\t\t\t\tname = Action\n" +
                                "\t\t\t\t\t}\n" +
                                "\t\t\t\t}\n" +
                                "\t\t\t}\n" +
                                "\t\t}");
            }

            if (generateConditionalAction) {
                System.out.println(
                        "\t\tConditionalAction\n" +
                                "\t\t{\n" +
                                "\t\t\tid = " + conditionalActionId + "\n" +
                                "\t\t\tname = Select random delivery objective"
                );
            }
            conditionalActionId++;
            for (int i = 1; i <= amount; i++) {
                boolean firstBlock = i == 1;
                boolean lastBlock = i == amount;
                if (generateConditionalAction) {
                    String padding = firstBlock || lastBlock ? "" : "\t";
                    if (firstBlock) {
                        System.out.println(
                                "\t\t\tBASE_BLOCK\n" +
                                "\t\t\t{");
                    }
                    if (!firstBlock && !lastBlock) {
                        System.out.println(
                                "\t\t\t\tELSE_IF\n" +
                                "\t\t\t\t{"
                        );
                    }

                    if (!lastBlock) {
                        System.out.println(
                                padding + "\t\t\t\tblockName = 1/" + (amount - i + 1) + "\n" +
                                padding + "\t\t\t\tblockId = " + conditionalActionId + "\n" +
                                padding + "\t\t\t\tCONDITIONAL\n" +
                                padding + "\t\t\t\t{\n" +
                                padding + "\t\t\t\t\tid = 0\n" +
                                padding + "\t\t\t\t\toutputNodePos = (0, 0, 0)\n" +
                                padding + "\t\t\t\t\troot = 0\n" +
                                padding + "\t\t\t\t\tCOMP\n" +
                                padding + "\t\t\t\t\t{\n" +
                                padding + "\t\t\t\t\t\tid = 0\n" +
                                padding + "\t\t\t\t\t\ttype = SCCChance\n" +
                                padding + "\t\t\t\t\t\tuiPos = (-258, 43, 0)\n" +
                                padding + "\t\t\t\t\t\tchance = " + Math.round( 100f / (amount - i + 1)) + "\n" +
                                padding + "\t\t\t\t\t}\n" +
                                padding + "\t\t\t\t}\n" +
                                padding + "\t\t\t\tACTIONS");
                    } else {
                        System.out.println(
                                padding + "\t\t\t\tELSE_ACTIONS");
                    }
                    System.out.println(
                            padding + "\t\t\t\t{\n" +
                            padding + "\t\t\t\t\teventName = \n" +
                            padding + "\t\t\t\t\tEventTarget\n" +
                            padding + "\t\t\t\t\t{\n" +
                            padding + "\t\t\t\t\t\ttargetType = Objective\n" +
                            padding + "\t\t\t\t\t\ttargetID = " + objectiveId + "\n" +
                            padding + "\t\t\t\t\t\teventName = Begin Objective\n" +
                            padding + "\t\t\t\t\t\tmethodName = BeginObjective\n" +
                            padding + "\t\t\t\t\t}\n" +
                            padding + "\t\t\t\t\tEventTarget\n" +
                            padding + "\t\t\t\t\t{\n" +
                            padding + "\t\t\t\t\t\ttargetType = Objective\n" +
                            padding + "\t\t\t\t\t\ttargetID = " + (objectiveId + objectiveIdDiff)+ "\n" +
                            padding + "\t\t\t\t\t\teventName = Begin Objective\n" +
                            padding + "\t\t\t\t\t\tmethodName = BeginObjective\n" +
                            padding + "\t\t\t\t\t}\n" +
                            padding + "\t\t\t\t}"
                    );
                    if(!firstBlock && !lastBlock) {
                        System.out.println("\t\t\t\t}");
                    }
                }
                objectiveId++;
                if (!lastBlock) {
                    conditionalActionId++;
                }
            }
            if (generateConditionalAction) {
                System.out.println(
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
                                "\t\t\t\tgv = " + (blue ? 0 : 1) +"\n" +
                                "\t\t\t\tcomparison = Equals\n" +
                                "\t\t\t\tc_value = " + number + "\n" +
                                "\t\t\t}\n" +
                                "\t\t}"
                );
            }
            conditionalId++;
            triggerId++;
        }
        System.out.println(objectiveId);
        System.out.println(orderId);
    }
}
