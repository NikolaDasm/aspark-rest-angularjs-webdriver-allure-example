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

import nikoladasm.examples.aspark_angularjs_rest.TestCase;

public class AddPage extends AbstractPage {

	public AddPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public AddPage typeTestCaseData(TestCase testCase) {
		WebElement titleInput = elementByXPath("/html/body/ng-view/main/form[1]/input[1]");
		titleInput.clear();
		titleInput.sendKeys(testCase.title);
		WebElement descriptionInput = elementByXPath("/html/body/ng-view/main/form[1]/input[2]");
		descriptionInput.clear();
		descriptionInput.sendKeys(testCase.description);
		WebElement priorityInput = elementByXPath("/html/body/ng-view/main/form[1]/input[3]");
		priorityInput.clear();
		priorityInput.sendKeys(String.valueOf(testCase.priority));
		WebElement locationInput = elementByXPath("/html/body/ng-view/main/form[1]/input[4]");
		locationInput.clear();
		locationInput.sendKeys(testCase.location);
		WebElement statusInput = elementByXPath("/html/body/ng-view/main/form[1]/input[5]");
		statusInput.clear();
		statusInput.sendKeys(String.valueOf(testCase.status));
		WebElement stepsInput = elementByXPath("/html/body/ng-view/main/form[1]/textarea[1]");
		stepsInput.clear();
		stepsInput.sendKeys(testCase.steps);
		WebElement expectedResultsInput = elementByXPath("/html/body/ng-view/main/form[1]/textarea[2]");
		expectedResultsInput.clear();
		expectedResultsInput.sendKeys(testCase.expectedResults);
		WebElement assignedToInput = elementByXPath("/html/body/ng-view/main/form[1]/input[6]");
		assignedToInput.clear();
		assignedToInput.sendKeys(testCase.assignedTo);
		WebElement ownerInput = elementByXPath("/html/body/ng-view/main/form[1]/input[7]");
		ownerInput.clear();
		ownerInput.sendKeys(testCase.owner);
		WebElement versionInput = elementByXPath("/html/body/ng-view/main/form[1]/input[8]");
		versionInput.clear();
		versionInput.sendKeys(String.valueOf(testCase.version));
		return this;
	}

	public MainPage submitAndReturnToMainPage() {
		elementByXPath("/html/body/ng-view/main/form[1]/button").click();
		return new MainPage(driver);
	}

	public AddPage submit() {
		elementByXPath("/html/body/ng-view/main/form[1]/button").click();
		return this;
	}

	public String headerText() {
		return elementByXPath("/html/body/ng-view/main/h3").getText();
	}
}
