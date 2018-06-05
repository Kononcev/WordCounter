package constant;

import java.util.regex.Pattern;

public interface Constants {
   Pattern ONLY_WORD_CHARACTERS = Pattern.compile("'?\\w[\\w']*(?:-\\w+)*'?");
}
