package com.example.reciclasanja;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseQuery {

    public void InsertObjectDb(Object obj, String tableName, String idObj, DatabaseReference databaseReference){

        databaseReference.child(tableName).child(idObj).setValue(obj);
    }

    public void UpdateObjetcDb(Object obj, String tableName, String idObj, DatabaseReference databaseReference){
        databaseReference.child(tableName).child(idObj).setValue(obj);
    }

    public void DeleteObjectDb(Object obj, String tableName, String idObj, DatabaseReference databaseReference){
        databaseReference.child(tableName).child(idObj).removeValue();
    }

    public ArrayList SelectObjectDb(String tableName, final ArrayList lstObj, final Object obj, DatabaseReference databaseReference){

        databaseReference.child(tableName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lstObj.clear();
                for(DataSnapshot objSaSnapshot:dataSnapshot.getChildren()){
                    Object objPopulado = objSaSnapshot.getValue(obj.getClass());

                    lstObj.add(objPopulado);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return lstObj;
    }

    public void SelectObjectById(){

    }
}

