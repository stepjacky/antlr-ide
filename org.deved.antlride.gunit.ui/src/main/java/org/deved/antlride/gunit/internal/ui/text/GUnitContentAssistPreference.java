/*******************************************************************************
 * Copyright (c) 2007, 2008 Edgar Espina.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/

package org.deved.antlride.gunit.internal.ui.text;

import org.deved.antlride.gunit.ui.GUnitUI;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.dltk.ui.text.completion.ContentAssistPreference;

public class GUnitContentAssistPreference extends ContentAssistPreference {

	private static GUnitContentAssistPreference sDefault;

	public static ContentAssistPreference getDefault() {
	    if (sDefault == null) {
	      sDefault = new GUnitContentAssistPreference();
	    }
	    return sDefault;
	  }
	
	@Override
	protected ScriptTextTools getTextTools() {
		return GUnitUI.getDefault().getTextTools();
	}

}
