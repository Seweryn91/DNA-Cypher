package buisness;

import GUI.PropertiesManager;
import buisness.interfaces.*;

import java.io.File;
import java.io.IOException;

public class MessageProcessor {

    private Message message;

    public Message processEncoding(File file) {
        Message message = new Message();
        TextFilePreparator textFilePreparator = new TextFilePreparatorImpl();
        String prepared = textFilePreparator.prepareTextFile(file);
        Encoder encoder = new EncoderImpl();
        String encoded = encoder.encode(prepared);
        PropertiesManager propertiesManager= new PropertiesManager();
        MutationKeyGenerator mutationKeyGenerator = new MutationKeyGeneratorImpl(propertiesManager);
        String mutationKey = mutationKeyGenerator.generateKey(encoded);
        message.setKey(mutationKey);
        Mutator mutator = new MutatorImpl();
        String mutated = mutator.mutate(mutationKey, encoded);
        message.setText(mutated);
        TextFileWriter textFileWriter = new TextFileWriter();
        try {
            textFileWriter.writeToFile(file.getPath(), mutated, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public Message processDecoding(File file, String mutationKey) {
        Message message = new Message();
        Demutator demutator = new DemutatorImpl();
        TextFilePreparator textFilePreparator = new TextFilePreparatorImpl();
        String prepared = textFilePreparator.prepareTextFile(file);
        String demutated = demutator.demutate(mutationKey, prepared);
        Decoder decoder = new DecoderImpl();
        String decoded = decoder.decode(demutated);
        message.setText(decoded);
        TextFileWriter textFileWriter = new TextFileWriter();
        try {
            textFileWriter.writeToFile(file.getPath(), decoded, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
