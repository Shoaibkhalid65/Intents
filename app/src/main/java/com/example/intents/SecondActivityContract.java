package com.example.intents;

import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondActivityContract extends ActivityResultContract<SecondActivityArgument,String> {
    public static final String FIRST_NAME = "first name";
    public static final String SECOND_NAME = "second name";
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, SecondActivityArgument secondActivityArgument) {
        Intent intent=new Intent(context, MainActivity2.class);
        intent.putExtra(FIRST_NAME,secondActivityArgument.firstName);
        intent.putExtra(SECOND_NAME,secondActivityArgument.secondName);
        return intent;
    }

    @Override
    public String parseResult(int i, @Nullable Intent intent) {
        return intent.getData().toString();
    }
}
class SecondActivityArgument{
    public String firstName;
    public String secondName;
    public SecondActivityArgument(){
    }
    public SecondActivityArgument(String firstName,String secondName){
        this.firstName=firstName;
        this.secondName=secondName;
    }

}

