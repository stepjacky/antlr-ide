/*******************************************************************************
 * Copyright (c) 2007, 2008 Edgar Espina.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package org.deved.antlride.stringtemplate.internal.ui.text.highlighting;

import java.util.ArrayList;
import java.util.List;

import org.deved.antlride.common.ui.text.highlighting.AntlrBaseHighlightScanner;
import org.deved.antlride.stringtemplate.ui.StringTemplateUIConstants;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;

public class StringTemplateSTGMultilineCommentHighlightScanner extends
		AntlrBaseHighlightScanner {

	private static final String[] TOKENS = {
			StringTemplateUIConstants.SH_STG_MULTI_LINE_COMMENT,
			StringTemplateUIConstants.SH_STG_DOC_COMMENT };

	public StringTemplateSTGMultilineCommentHighlightScanner(
			IColorManager manager, IPreferenceStore store) {
		super(manager, store);
	}

	@Override
	protected List<IRule> createRules() {
		List<IRule> rules = new ArrayList<IRule>();
		Token multilineComment = getToken(StringTemplateUIConstants.SH_STG_MULTI_LINE_COMMENT);
		Token documentComment = getToken(StringTemplateUIConstants.SH_STG_DOC_COMMENT);
		rules.add(new MultiLineRule("/**", "*/", documentComment));
		rules.add(new MultiLineRule("/*", "*/", multilineComment));
		setDefaultReturnToken(multilineComment);
		return rules;
	}

	@Override
	protected String[] getTokenProperties() {
		return TOKENS;
	}

}