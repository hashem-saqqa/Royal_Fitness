package com.example.royalfitnessmhr;

public class Gym {
    private int imge;
    private String name;

    public Gym(int imge, String name) {
        this.imge = imge;
        this.name = name;
    }

    public int getImge() {
        return imge;
    }

    public void setImge(int imge) {
        this.imge = imge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
