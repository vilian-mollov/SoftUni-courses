package Polymorphism.exercise.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {
    class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex){
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }
    class CutTransform implements TextTransform{
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            StringBuilder cut = new StringBuilder();
            for (int i = startIndex; i < endIndex; i++) {
                cut.append(text.charAt(i));
            }
            text.delete(startIndex,endIndex);
            CommandImpl.cut = cut;
        }
    }
    class PasteTransform implements TextTransform{
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            text.deleteCharAt(startIndex);
            text.insert(startIndex,cut);

        }
    }
    private static StringBuilder cut;
    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.init();
        this.text = text;
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut",new CutTransform()));
        commands.add(new Command("paste",new PasteTransform()));

        return commands;
    }
}
