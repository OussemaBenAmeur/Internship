package org.example;

import net.thevpc.nuts.NOut;
import net.thevpc.nuts.util.NMsg;

public class Drawer {
    XHashtable ht;
//constructeur
    public Drawer(XHashtable ht) {
        this.ht = ht;
    }
    //-----------------------------------
// fi blaset .repeat() li mch mwjouda fl version hethy taa java
    private String repeat(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
//------------------------------------
    public void draw() {
        String[] colors = {"##:11:%s##", "##:1:%s##", "##:5:%s##", "##:8:%s##", "##:10:%s##", "##:13:%s##",
                "##:12:%s##", "##:2:%s##", "##:9:%s##", "##:4:%s##", "##:6:%s##", "##:7:%s##",};

        for (int i = 0; i < ht.getSize(); i++) {
            String color = colors[i % colors.length];//couleur
            Node current = ht.table[i].head;//parcoureur


            String bucketTop, bucketMid, bucketBot, bucketDownConnector;
            String arrow = "--->";
            //louken tableau len <10
            if (i < 10) {
                bucketTop =           "╔═══╩═══╗";
                bucketMid =           "║   " + i + "   ╠";
                bucketBot =           "╚═══╦═══╝";
                bucketDownConnector = "    ╬";
            }
            else {
                bucketTop =           "╔═══╩════╗";
                bucketMid =           "║   " + i +  "   ╠";
                bucketBot =           "╚═══╦════╝";
                bucketDownConnector = "    ╬";
            }



            if (current == null) {//louken bucket feregh
                NOut.println(NMsg.ofC(color, bucketTop));//rasou
                NOut.print(NMsg.ofC(color, bucketMid + arrow));//wostou
                NOut.println("##:f280:N## ##:f210:U## ##:f141:L## ##:f70:L##");//wostou
                NOut.println(NMsg.ofC(color, bucketBot));//sa9ih
            } else
            {//louken bucket fih hajeet
                // chaines mutables
                StringBuilder chainLine1 = new StringBuilder();
                StringBuilder chainLine2 = new StringBuilder();
                StringBuilder chainLine3 = new StringBuilder();
                //parcourir linked list
                Node nodeIterator = current;
                while (nodeIterator != null) {
                    String key = nodeIterator.key;
                    int keyLen = key.length();


                    String nodeTop = "┌" + repeat('─', keyLen + 2) + "┐";
                    String nodeMid = "│ " + key + " │";
                    String nodeBot = "└" + repeat('─', keyLen + 2) + "┘";


                    chainLine1.append(nodeTop);
                    chainLine2.append(nodeMid);
                    chainLine3.append(nodeBot);


                    if (nodeIterator.next != null) {
                        String connector = "<===>";

                        chainLine1.append(repeat(' ', connector.length()));
                        chainLine2.append(connector);
                        chainLine3.append(repeat(' ', connector.length()));
                    }
                    nodeIterator = nodeIterator.next;
                }

                //mokh l hadra
                String arrowSpacing = repeat(' ', arrow.length());
                NOut.println(NMsg.ofC(color, bucketTop + arrowSpacing + chainLine1.toString()));
                NOut.print(NMsg.ofC(color, bucketMid + arrow + chainLine2.toString() + arrow  ));
                NOut.println("##:f280:N## ##:f210:U## ##:f141:L## ##:f70:L##");//wostou
                NOut.println(NMsg.ofC(color, bucketBot + arrowSpacing + chainLine3.toString()));
            }


            NOut.println(NMsg.ofC(color, bucketDownConnector));

        }

        NOut.println(NMsg.ofC(colors[0], "    ╨"));
    }
}