package com.company;

public class Zoo {
    private Lion lion;
    private Giraffe giraffe;
    private Tiger tiger;

    public Lion getLion() {
        return lion;
    }

    public void setLion(Lion lion) {
        this.lion = lion;
    }

    public Giraffe getGiraffe() {
        return giraffe;
    }

    public void setGiraffe(Giraffe giraffe) {
        this.giraffe = giraffe;
    }

    public Tiger getTiger() {
        return tiger;
    }

    public void setTiger(Tiger tiger) {
        this.tiger = tiger;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "lion [" + lion.getName() + ", " + lion.getAge() +
                "], giraffe [" + giraffe.getName() + ", " + giraffe.getAge() +
                "], tiger [" + tiger.getName() + ", " + tiger.getAge() +
                "]}";
    }
}
