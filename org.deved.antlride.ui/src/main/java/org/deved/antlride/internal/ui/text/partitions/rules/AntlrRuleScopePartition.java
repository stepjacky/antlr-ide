/*******************************************************************************
 * Copyright (c) 2007, 2008 Edgar Espina.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.deved.antlride.internal.ui.text.partitions.rules;

import org.deved.antlride.common.ui.text.partitions.rules.AntlrBlockPartition;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class AntlrRuleScopePartition extends AntlrBlockPartition {

  public AntlrRuleScopePartition(IToken successToken) {
    super(successToken);
    addExclusionPattern("scope");
    addExclusionPattern("@");
  }

  @Override
  protected IToken doEvaluate(ICharacterScanner scanner) {
    consumeWord(scanner);
    String text = getTextReaded();
    if (text.equals("scope")) {
      consumeWS(scanner);
      consumeOne(scanner);
      text = getTextReaded();
      if (text.equals("{")) {
        IToken doBlock = doBlock(scanner);
        return doBlock;
      }
    }
    unread(scanner);
    return Token.UNDEFINED;
  }

}
