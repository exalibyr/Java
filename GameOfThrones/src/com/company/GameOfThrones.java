package com.company;

import java.util.List;

public class GameOfThrones {
    private List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Character character: characters){           //may erase foreach and put
            sb.append(character.toString())             //sb.append(characters).toString() instead of sb.toString()
                    .append("\n")                       //to return key-word if you want a long line :)
                    .append("\t\t\t\t\t\t");
        }
        return "GameOfThrones{" +
                "characters=" +
                sb.toString() +
                '}';
    }
}
