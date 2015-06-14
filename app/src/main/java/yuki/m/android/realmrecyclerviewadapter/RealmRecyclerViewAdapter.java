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

import io.realm.RealmObject;
import io.realm.RealmResults;

public abstract class RealmRecyclerViewAdapter<T extends RealmObject, VH extends RecyclerView.ViewHolder>
    extends RecyclerView.Adapter<VH> {

  protected RealmResults<T> realmResults;
  protected Context context;

  public RealmRecyclerViewAdapter(Context context, RealmResults<T> realmResults) {
    if (context == null) {
      throw new IllegalArgumentException("Context cannot be null");
    }
    if (realmResults == null) {
      throw new IllegalArgumentException("RealmResults cannot be null");
    }

    this.realmResults = realmResults;
    this.context = context;
  }
  
  @Override
  public int getItemCount() {
    return realmResults.size();
  }
}
