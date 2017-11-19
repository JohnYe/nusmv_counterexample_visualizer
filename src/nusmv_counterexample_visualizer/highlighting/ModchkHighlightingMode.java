package nusmv_counterexample_visualizer.highlighting;

import nusmv_counterexample_visualizer.formula.LTLFormula;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by buzhinsky on 11/15/17.
 */
class ModchkHighlightingMode extends HighlightingMode {
    @Override
    public String name() {
        return "MODCHK";
    }

    @Override
    public String visualizeValueNoUrl(String s, boolean value, boolean highlight) {
        final String color = (value ? "color=red" : "color=gray") + (highlight ? " bgcolor=yellow" : "");
        return "<font " + color + ">" + s + "</font>";
    }

    @Override
    public String visualizeImportance(String s, boolean important) {
        return important ? ("<span style='text-decoration: underline; background-color: yellow;'>"
                + s + "</span>") : s;
    }

    @Override
    public String visualizeImportanceInTable(String s, boolean important) {
        return visualizeImportance(s, important);
    }

    @Override
    public List<String> shortGraphicalAnnotateString(String str, boolean value, boolean important) {
        final Function<String, String> bold = value ? s -> "<b>" + s + "</b>" : s -> s;
        return Arrays.asList("<font bgcolor=" + (value ? "#00ff00" : "white") + ">" + bold.apply(str) + "</font>",
                "<font color=red>" + bold.apply(LTLFormula.nStrings(important ? "*" : "&nbsp",
                        LTLFormula.lengthWithoutTags(str)) + "</font>"));
    }
}
