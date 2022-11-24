package kata6;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Abilities {
    public Ability ability;
    public String is_hidden;
    public String slot;

    @Override
    public String toString() {
        return "Abilities{" + "ability=" + ability + ", is_hidden=" + is_hidden + ", slot=" + slot + '}';
    }

    
    public static class Ability{
        public String name;
        public String url;

        @Override
        public String toString() {
            return "Ability{" + name + '}';
        }
        
        
    }
    
}
    
    
