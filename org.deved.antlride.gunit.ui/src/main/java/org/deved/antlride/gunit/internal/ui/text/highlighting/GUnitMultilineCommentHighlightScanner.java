/*******************************************************************************
 * Copyright (c) 2007, 2008 Edgar Espina.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.deved.antlride.gunit.internal.ui.text.highlighting;

import java.util.ArrayList;
import java.util.List;

import org.deved.antlride.common.ui.text.highlighting.AntlrBaseHighlightScanner;
import org.deved.antlride.gunit.ui.GUnitUIConstants;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;

public class GUnitMultilineCommentHighlightScanner extends
		AntlrBaseHighlightScanner {

	private static final String[] TOKENS = {
			GUnitUIConstants.SH_MULTI_LINE_COMMENT, GUnitUIConstants.SH_DOC_COMMENT};

	public GUnitMultilineCommentHighlightScanner(
			IColorManager manager, IPreferenceStore store) {
		super(manager, store);
	}

	@Override
	protected List<IRule> createRules() {
		List<IRule> rules = new ArrayList<IRule>();
		Token multilineComment = getToken(GUnitUIConstants.SH_MULTI_LINE_COMMENT);
		Token docComment = getToken(GUnitUIConstants.SH_DOC_COMMENT);
		rules.add(new MultiLineRule("/**", "*/", docComment));
		setDefaultReturnToken(multilineComment);
		return rules;
	}

	@Override
	protected String[] getTokenProperties() {
		return TOKENS;
	}

}
