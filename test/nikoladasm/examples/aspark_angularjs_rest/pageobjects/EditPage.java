/*
 *  Examples: ASpark REST AngularJS WEBDriver Allure
 *  Copyright (C) 2015  Nikolay Platov
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nikoladasm.examples.aspark_angularjs_rest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage extends AbstractPage {

	public EditPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public EditPage typeTestCaseSteps(String steps) {
		WebElement stepsInput = elementByXPath("/html/body/ng-view/main/form[1]/textarea[1]");
		stepsInput.clear();
		stepsInput.sendKeys(steps);
		return this;
	}

	public EditPage typeTestCaseTitle(String steps) {
		WebElement stepsInput = elementByXPath("/html/body/ng-view/main/form[1]/input[1]");
		stepsInput.clear();
		stepsInput.sendKeys(steps);
		return this;
	}
	
	public EditPage typeTestCaseVersion(int version) {
		WebElement versionInput = elementByXPath("/html/body/ng-view/main/form[1]/input[8]");
		versionInput.clear();
		versionInput.sendKeys(String.valueOf(version));
		return this;
	}
	
	public String testCaseStepsText() {
		return elementByXPath("/html/body/ng-view/main/form[1]/textarea[1]").getText();
	}
	
	public String testCaseStepsText(String expectedText) {
		return elementByXPath("/html/body/ng-view/main/form[1]/textarea[1]").getAttribute("value");
	}
	
	public MainPage submitAndReturnToMainPage() {
		elementByXPath("/html/body/ng-view/main/form[1]/button").click();
		return new MainPage(driver);
	}

	public EditPage submit() {
		elementByXPath("/html/body/ng-view/main/form[1]/button").click();
		return this;
	}
	
	public String headerText() {
		return elementByXPath("/html/body/ng-view/main/h3").getText();
	}
}
