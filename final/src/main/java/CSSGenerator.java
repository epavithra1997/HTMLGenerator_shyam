import java.util.HashMap;
import java.util.Map;

public class CSSGenerator {

    private HashMap<String, ElementDetails> elementDetails;

    CSSGenerator(HashMap<String, ElementDetails> elementDetails){
        this.elementDetails = elementDetails;
    }

    public String builtCSSFormatContent(){
        StringBuilder stringBuilder = new StringBuilder();

        elementDetails.forEach((key, value) -> {
            if(value.getCssStyles().size() == 0){
                return;
            }

            stringBuilder.append(".").append(value.getName()).append("{").append("\n");
            for (Map.Entry<String, String> entry : value.getCssStyles().entrySet()) {
                stringBuilder.append("\t").append(entry.getKey()).append(" : ").append(entry.getValue()).append(";").append("\n");
            }
            stringBuilder.append("}").append("\n\n");
        });
        return stringBuilder.toString();
    }
}
