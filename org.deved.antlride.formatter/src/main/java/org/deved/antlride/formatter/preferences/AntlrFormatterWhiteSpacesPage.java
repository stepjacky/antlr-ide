/*******************************************************************************
 * Copyright (c) 2007, 2008 Edgar Espina.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/

package org.deved.antlride.formatter.preferences;

import java.net.URL;

import org.deved.antlride.core.formatter.AntlrFormatterPreferences;
import org.eclipse.dltk.ui.formatter.FormatterModifyTabPage;
import org.eclipse.dltk.ui.formatter.IFormatterControlManager;
import org.eclipse.dltk.ui.formatter.IFormatterModifyDialog;
import org.eclipse.dltk.ui.util.SWTFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class AntlrFormatterWhiteSpacesPage extends FormatterModifyTabPage {

	private static final URL PREVIEW = AntlrFormatterWhiteSpacesPage.class
			.getResource("whitespaces-preview"); //$NON-NLS-1$;

	/**
	 * @param dialog
	 */
	public AntlrFormatterWhiteSpacesPage(IFormatterModifyDialog dialog) {
		super(dialog);
	}

	protected void createOptions(IFormatterControlManager manager,
			Composite parent) {

		manager = new AntlrFormatterControlManager(manager);

		// White Spaces
		Group group = SWTFactory.createGroup(parent,
				AntlrFormatterMessages.WhiteSpacesInSections, 1, 1,
				GridData.FILL_HORIZONTAL);

		manager.createCheckbox(group,
				AntlrFormatterPreferences.WhiteSpaces.BEFORE_AFTER_OPTION,
				AntlrFormatterMessages.WhiteSpaces_beforeAfterOption);

		manager.createCheckbox(group,
				AntlrFormatterPreferences.WhiteSpaces.BEFORE_AFTER_TOKEN,
				AntlrFormatterMessages.WhiteSpaces_beforeAfterToken);

		group = SWTFactory.createGroup(parent,
				AntlrFormatterMessages.WhiteSpacesInStatements, 1, 1,
				GridData.FILL_HORIZONTAL);

		manager.createCheckbox(group,
				AntlrFormatterPreferences.WhiteSpaces.BEFORE_AFTER_ASSIGN,
				AntlrFormatterMessages.WhiteSpaces_beforeAfterAssign);
		manager
				.createCheckbox(
						group,
						AntlrFormatterPreferences.WhiteSpaces.BEFORE_AFTER_BLOCK_PARENTHESIS,
						AntlrFormatterMessages.WhiteSpaces_beforeAfterBlockParenthesis);
	}

	protected URL getPreviewContent() {
		return PREVIEW;
	}

}
