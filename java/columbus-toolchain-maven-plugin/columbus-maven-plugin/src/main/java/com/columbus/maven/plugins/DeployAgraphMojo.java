/*
 *  This file is part of OpenStaticAnalyzer.
 *
 *  Copyright (c) 2004-2018 Department of Software Engineering - University of Szeged
 *
 *  Licensed under Version 1.2 of the EUPL (the "Licence");
 *
 *  You may not use this work except in compliance with the Licence.
 *
 *  You may obtain a copy of the Licence in the LICENSE file or at:
 *
 *  https://joinup.ec.europa.eu/software/page/eupl
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the Licence is distributed on an "AS IS" basis,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the Licence for the specific language governing permissions and
 *  limitations under the Licence.
 */

package com.columbus.maven.plugins;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;



@Mojo(name = "deploy-agraph", defaultPhase = LifecyclePhase.COMPILE, threadSafe = true, requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME)
public class DeployAgraphMojo extends AbstractColumbusMojo {

  public void execute() throws MojoExecutionException, MojoFailureException {
    if (project.getPackaging().equals("pom")) {
      getLog().info("The" + project.getName() + " is not a jar project");
      return;
    }
    init();

    //
    runDependency();

    // upload
    executeMojo(
        getMyPlugin(),
        "deploy-file",
        element("file", EnvManager.getInstance().getInstance()
            .getMergedAGraphFileName()),
        element("artifactId", project.getArtifactId()),
        element("classifier", EnvManager.OSA_CLASSIFER_AGRAP),
        element("groupId", project.getGroupId()),
        element("packaging", "jar"),
        element("version", project.getVersion()),
        element("url", project.getDistributionManagement().getRepository()
            .getUrl()));

  }

  private void runDependency() throws MojoExecutionException {
    executeMojo(getMyPlugin(), "agraph");
  }
}
