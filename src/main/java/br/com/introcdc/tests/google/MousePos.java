package br.com.introcdc.tests.google;
/*
 * Written by IntroCDC, Bruno Coelho at 25/12/2022 - 00:50
 */

import java.util.HashMap;
import java.util.Map;

public enum MousePos {
    DOLAR() {
        @Override
        public void setConsumer(Map<VoteClient, Integer[]> consumer) {
            consumer.put(VoteClient.TABLET, new Integer[]{553, 319});
            consumer.put(VoteClient.PC_SECONDARY, new Integer[]{588, 238});
        }
    },
    SAFIRA_1() {
        @Override
        public void setConsumer(Map<VoteClient, Integer[]> consumer) {
            consumer.put(VoteClient.TABLET, new Integer[]{553, 493});
            consumer.put(VoteClient.PC_SECONDARY, new Integer[]{588, 353});
        }
    },
    SAFIRA_2() {
        @Override
        public void setConsumer(Map<VoteClient, Integer[]> consumer) {
            consumer.put(VoteClient.TABLET, new Integer[]{553, 645});
            consumer.put(VoteClient.PC_SECONDARY, new Integer[]{588, 455});
        }
    },
    COXINHA {
        @Override
        public void setConsumer(Map<VoteClient, Integer[]> consumer) {
            consumer.put(VoteClient.TABLET, new Integer[]{553, 857});
            consumer.put(VoteClient.PC_SECONDARY, new Integer[]{588, 596});
        }
    },
    SEND {
        @Override
        public void setConsumer(Map<VoteClient, Integer[]> consumer) {
            consumer.put(VoteClient.TABLET, new Integer[]{553, 893});
            consumer.put(VoteClient.PC_SECONDARY, new Integer[]{588, 623});
        }
    },
    RESTART {
        @Override
        public void setConsumer(Map<VoteClient, Integer[]> consumer) {
            consumer.put(VoteClient.TABLET, new Integer[]{515, 55});
            consumer.put(VoteClient.PC_SECONDARY, new Integer[]{588, 50});
        }
    };

    private final Map<VoteClient, Integer[]> posMap = new HashMap<>();

    public Map<VoteClient, Integer[]> getPosMap() {
        return posMap;
    }

    public void setConsumer(Map<VoteClient, Integer[]> consumer) {
    }

    public int getX(VoteClient client) {
        return getPosMap().get(client)[0];
    }

    public int getY(VoteClient client) {
        return getPosMap().get(client)[1];
    }

}
