package core.utils;

import core.data.globalVariable;

import java.util.HashMap;

public class SearchContext {

    globalVariable variable;
    private HashMap<globalVariable,Object> globalStore;

    public SearchContext(){
        globalStore=new HashMap<>();
    }
    public Object getGlobalStore(globalVariable ObjectKey) {

        return globalStore.get(ObjectKey);
    }

    public void setGlobalStore(globalVariable key, Object value) {
        globalStore.put(key,value);
    }
    public  boolean containsKey(globalVariable key){

        return globalStore.containsKey(key);
    }
}
