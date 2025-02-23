package charaplanner.ui;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Setter;


@Setter
@XmlRootElement(name = "characters")
public class CharaListWrapper {
    private List<charaplanner.data.Character> characters;

    @XmlElement(name = "character")
    public List<charaplanner.data.Character> getCharacters() {
        return characters;
    }
}
