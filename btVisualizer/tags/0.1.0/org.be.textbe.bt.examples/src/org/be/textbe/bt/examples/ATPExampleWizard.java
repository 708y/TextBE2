/*
 * @author tmyers
 * @version 0.1
 * @created 07.05.2010
 * 
 */

package org.be.textbe.bt.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ATPExampleWizard extends AbstractExampleWizard{
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		final List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		projects.add(new ProjectDescriptor("org.be.textbe.bt.examples", "examples/org.be.textbe.bt.examples.automated_train_protection.zip", "org.be.textbe.bt.examples.automated_train_protection"));
		return projects;
	}
}