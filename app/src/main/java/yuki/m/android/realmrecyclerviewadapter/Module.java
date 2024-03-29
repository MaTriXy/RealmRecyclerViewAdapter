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

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Module extends RealmObject {

  @PrimaryKey private String id;
  private double value;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double payment) {
    this.value = value;
  }
}
