/*
 * Copyright 2015 yuki312 All Right Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yuki.m.android.realmrecyclerviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmResults;

public class HelloActivity extends AppCompatActivity {

  private Realm realm;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    realm = Realm.getInstance(this);
    RealmResults<Module> modules = realm.where(Module.class).findAll();
    if (modules.size() == 0) {
      realm.beginTransaction();
      realm.createAllFromJson(Module.class, 
          "[ { id:100, value:100 }, {id:200, value:200} ]");
      realm.commitTransaction();
      modules = realm.where(Module.class).findAll();
    }
    
    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
    recyclerView.setHasFixedSize(false);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new ModuleAdapter(this, modules));
  }
}
