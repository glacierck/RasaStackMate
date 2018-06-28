package model;

import controller.IntentViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.inject.Singleton;
import java.util.HashMap;


public class IntentManagerImpl implements IntentManager {

    HashMap<String, Intent> intents;
    ObservableList<String> intentNames;


    public IntentManagerImpl() {
        this.intents = new HashMap<>();
        this.intentNames = FXCollections.observableArrayList();
    }


    public void addIntentExample(String intentName, String example){
        intents.get(intentName).addExample(example);
    }


    public void addIntent(String intentName){
        if(!intents.containsKey(intentName)){
            this.intents.put(intentName,new Intent());
            this.intentNames.add(intentName);
        }
    }


    public void deleteIntent(String intentName) {
        this.intents.remove(intentName);
        this.intentNames.remove(intentName);
    }


    public Intent getIntent(String intentName) {
        return this.intents.get(intentName);
    }


    public ObservableList<String> getIntentNames() {
        return this.intentNames;
    }


    public HashMap<String,Intent> getIntents(){
        return this.intents;
    }

    public void deleteIntentExample(String intentName, String example){
        this.intents.get(intentName).deleteExample(example);
    }

    public ObservableList<String> getExamplesToIntent(String intentName){
        return this.intents.get(intentName).getExamples();
    }


}


