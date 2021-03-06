/*
* Copyright (C) 2014 Google, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;
import static test.PrimitivesModule.BOUND_BOOLEAN;
import static test.PrimitivesModule.BOUND_BOOLEAN_ARRAY;
import static test.PrimitivesModule.BOUND_BYTE;
import static test.PrimitivesModule.BOUND_BYTE_ARRAY;
import static test.PrimitivesModule.BOUND_CHAR;
import static test.PrimitivesModule.BOUND_CHAR_ARRAY;
import static test.PrimitivesModule.BOUND_DOUBLE;
import static test.PrimitivesModule.BOUND_DOUBLE_ARRAY;
import static test.PrimitivesModule.BOUND_FLOAT;
import static test.PrimitivesModule.BOUND_FLOAT_ARRAY;
import static test.PrimitivesModule.BOUND_INT;
import static test.PrimitivesModule.BOUND_INT_ARRAY;
import static test.PrimitivesModule.BOUND_LONG;
import static test.PrimitivesModule.BOUND_LONG_ARRAY;
import static test.PrimitivesModule.BOUND_SHORT;
import static test.PrimitivesModule.BOUND_SHORT_ARRAY;

@RunWith(JUnit4.class)
public class BasicTest {
  @Test public void primitives() {
    BasicComponent basicComponent = Dagger_BasicComponent.create();
    assertThat(basicComponent.getByte()).isEqualTo(BOUND_BYTE);
    assertThat(basicComponent.getChar()).isEqualTo(BOUND_CHAR);
    assertThat(basicComponent.getShort()).isEqualTo(BOUND_SHORT);
    assertThat(basicComponent.getInt()).isEqualTo(BOUND_INT);
    assertThat(basicComponent.getLong()).isEqualTo(BOUND_LONG);
    assertThat(basicComponent.getBoolean()).isEqualTo(BOUND_BOOLEAN);
    assertThat(basicComponent.getFloat()).isEqualTo(BOUND_FLOAT);
    assertThat(basicComponent.getDouble()).isEqualTo(BOUND_DOUBLE);
  }

  @Test public void boxedPrimitives() {
    BasicComponent basicComponent = Dagger_BasicComponent.create();
    assertThat(basicComponent.getBoxedByte()).isEqualTo(new Byte(BOUND_BYTE));
    assertThat(basicComponent.getBoxedChar()).isEqualTo(new Character(BOUND_CHAR));
    assertThat(basicComponent.getBoxedShort()).isEqualTo(new Short(BOUND_SHORT));
    assertThat(basicComponent.getBoxedInt()).isEqualTo(new Integer(BOUND_INT));
    assertThat(basicComponent.getBoxedLong()).isEqualTo(new Long(BOUND_LONG));
    assertThat(basicComponent.getBoxedBoolean()).isEqualTo(new Boolean(BOUND_BOOLEAN));
    assertThat(basicComponent.getBoxedFloat()).isEqualTo(new Float(BOUND_FLOAT));
    assertThat(basicComponent.getBoxedDouble()).isEqualTo(new Double(BOUND_DOUBLE));
  }

  @Test public void primitiveArrays() {
    BasicComponent basicComponent = Dagger_BasicComponent.create();
    assertThat(basicComponent.getByteArray()).isSameAs(BOUND_BYTE_ARRAY);
    assertThat(basicComponent.getCharArray()).isSameAs(BOUND_CHAR_ARRAY);
    assertThat(basicComponent.getShortArray()).isSameAs(BOUND_SHORT_ARRAY);
    assertThat(basicComponent.getIntArray()).isSameAs(BOUND_INT_ARRAY);
    assertThat(basicComponent.getLongArray()).isSameAs(BOUND_LONG_ARRAY);
    assertThat(basicComponent.getBooleanArray()).isSameAs(BOUND_BOOLEAN_ARRAY);
    assertThat(basicComponent.getFloatArray()).isSameAs(BOUND_FLOAT_ARRAY);
    assertThat(basicComponent.getDoubleArray()).isSameAs(BOUND_DOUBLE_ARRAY);
  }

  @Test public void noOpMembersInjection() {
    BasicComponent basicComponent = Dagger_BasicComponent.create();
    Object object = new Object();
    assertThat(basicComponent.noOpMembersInjection(object)).isSameAs(object);
  }

  @Test public void basicObject_noDeps() {
    BasicComponent basicComponent = Dagger_BasicComponent.create();
    assertThat(basicComponent.thing()).isNotNull();
  }

  @Test public void inheritedMembersInjection() {
    BasicComponent basicComponent = Dagger_BasicComponent.create();
    assertThat(basicComponent.typeWithInheritedMembersInjection().thing).isNotNull();
  }
}
