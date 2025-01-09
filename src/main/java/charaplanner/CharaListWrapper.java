package charaplanner;

import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "characters")
public class CharaListWrapper {
    private List<Character> characters;

    @XmlElement(name = "character")
    public List<Character> getCharacters() {
        return characters;
    }
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
