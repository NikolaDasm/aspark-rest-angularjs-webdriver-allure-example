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

public class MainPage extends AbstractPage {

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public MainPage open() {
		driver().get("http://"+webServerIpAddress+":"+webServerPort+"/");
		return this;
	}
	
	public String navigationText(int index) {
		return elementByXPath("/html/body/ng-view/main/ul/li["+index+"]/span").getText();
	}

	public String navigationLinkText(int index) {
		return elementByXPath("/html/body/ng-view/main/ul/li["+index+"]/a").getText();
	}
	
	public String navigationLink(int index) {
		return elementByXPath("/html/body/ng-view/main/ul/li["+index+"]/a").getAttribute("href");
	}
	
	public String testCaseTitleText(int index) {
		return elementByXPath("/html/body/ng-view/main/table/tbody/tr["+index+"]/td[2]").getText();
	}
	
	public String testCaseEditLink(int index) {
		return elementByXPath("/html/body/ng-view/main/table/tbody/tr["+index+"]/td[12]/a").getAttribute("href");
	}

	public String testCaseDeleteLink(int index) {
		return elementByXPath("/html/body/ng-view/main/table/tbody/tr["+index+"]/td[13]/a").getAttribute("href");
	}
	
	public MainPage goToPage(int index) {
		elementByXPath("/html/body/ng-view/main/ul/li["+index+"]/a").click();
		return this;
	}
	
	public EditPage goToEditPage(int index) {
		elementByXPath("/html/body/ng-view/main/table/tbody/tr["+index+"]/td[12]/a").click();
		return new EditPage(driver);
	}

	public String testCaseStepsText(int index) {
		return elementByXPath("/html/body/ng-view/main/table/tbody/tr["+index+"]/td[8]").getText();
	}
	
	public DeletePage goToDeletePage(int index) {
		elementByXPath("/html/body/ng-view/main/table/tbody/tr["+index+"]/td[13]/a").click();
		return new DeletePage(driver);
	}

	public AddPage goToAddPage() {
		elementByXPath("/html/body/ng-view/main/a").click();
		return new AddPage(driver);
	}

	public String testCaseVersionText(int index) {
		return elementByXPath("/html/body/ng-view/main/table/tbody/tr["+index+"]/td[11]").getText();
	}
	
	public MainPage typeTitleInputText(String title) {
		WebElement titleInput = elementByXPath("/html/body/ng-view/main/form[1]/input[1]");
		titleInput.clear();
		titleInput.sendKeys(title);
		return this;
	}
	
	public FindPage submitAndGoToFindPage() {
		elementByXPath("/html/body/ng-view/main/form[1]/button").click();
		return new FindPage(driver);
	}
}
