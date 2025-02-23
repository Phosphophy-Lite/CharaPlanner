package charaplanner.ui;

import java.util.List;

import charaplanner.data.Character;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "characters")
public class CharaListWrapper {
    private List<charaplanner.data.Character> characters;

    @XmlElement(name = "character")
    public List<charaplanner.data.Character> getCharacters() {
        return characters;
    }
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
