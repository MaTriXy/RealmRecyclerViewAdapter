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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmResults;

public class ModuleAdapter extends RealmRecyclerViewAdapter<Module, ModuleAdapter.ViewHolder> {

  static class ViewHolder extends RecyclerView.ViewHolder {
    private TextView value, id;

    public ViewHolder(View v) {
      super(v);
      value = (TextView) v.findViewById(android.R.id.text1);
      id = (TextView) v.findViewById(android.R.id.text2);
    }
  }

  public ModuleAdapter(Context context, RealmResults<Module> realmResults) {
    super(context, realmResults);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(context)
        .inflate(android.R.layout.simple_list_item_2, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder view, int position) {
    Module module = realmResults.get(position);
    view.id.setText(module.getId());
    view.value.setText("value:" + module.getValue());
  }
}
