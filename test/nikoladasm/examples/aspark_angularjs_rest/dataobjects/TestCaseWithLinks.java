/*
 *  Examples: ASpark REST AngularJS WEBDriver Allure
 *  Copyright (C) 2016  Nikolay Platov
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nikoladasm.examples.aspark_angularjs_rest.dataobjects;

import nikoladasm.examples.aspark_angularjs_rest.TestCase;

public class TestCaseWithLinks {
	public int row;
	public TestCase testCase;
	public String editText;
	public String editReference;
	public String deleteText;
	public String deleteReference;
	
	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof TestCaseWithLinks)) return false;
		TestCaseWithLinks testCase = (TestCaseWithLinks) object;
		return (this.testCase == null ? testCase.testCase == null : this.testCase.equals(testCase.testCase)) &&
			(editText == null ? testCase.editText == null : editText.equals(testCase.editText)) &&
			(editReference == null ? testCase.editReference == null : editReference.equals(testCase.editReference)) &&
			(deleteText == null ? testCase.deleteText == null : deleteText.equals(testCase.deleteText)) &&
			(deleteReference == null ? testCase.deleteReference == null : deleteReference.equals(testCase.deleteReference)) &&
			row == testCase.row;
	}
}
