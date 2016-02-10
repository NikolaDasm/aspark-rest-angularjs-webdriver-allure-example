/*
 *  Examples: ASpark REST AngularJS WEBDriver Allure
 *  Copyright (C) 2015-2016  Nikolay Platov
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

package nikoladasm.examples.aspark_angularjs_rest;

import static nikoladasm.aspark.ASpark.*;

public class ApiResource {

	private static final String API_CONTEXT = "/api/v1";

	private ApiService service;
	
	public ApiResource(ApiService service) {
		this.service = service;
		setupTestCaseEndpoints();
	}

	private void setupTestCaseEndpoints() {
		get(API_CONTEXT+"/testcases", service::allTestCases);
		get(API_CONTEXT+"/testcases/range/:startWith/:count", service::testCasesRange);
		get(API_CONTEXT+"/testcases/count", service::testCasesCount);
		post(API_CONTEXT+"/testcases", service::addTestCase);
		get(API_CONTEXT+"/testcases/byid/:id", service::getTestCase);
		put(API_CONTEXT+"/testcases", service::editTestCase);
		delete(API_CONTEXT+"/testcases/:id", service::deleteTestCase);
		get(API_CONTEXT+"/testcases/bytitle", service::getTestCaseByTitle);
	}
}
