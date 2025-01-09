package charaplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Link {

    private final StringProperty linkLabel;
    private final StringProperty linkUrl;

    public Link() {
        this.linkLabel = new SimpleStringProperty("");
        this.linkUrl = new SimpleStringProperty("");
    }

    public String getLinkLabel() {
        return linkLabel.get();
    }

    public void setLinkLabel(String linkLabel){
        this.linkLabel.set(linkLabel);
    }

    public StringProperty getLinkLabelProperty(){
        return linkLabel;
    }

    public String getLinkUrl() {
        return linkUrl.get();
    }

    public void setLinkUrl(String url){
        this.linkUrl.set(url);
    }

    public StringProperty getLinkUrlProperty(){
        return linkUrl;
    }

}
