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

package nikoladasm.examples.aspark_angularjs_rest;

import nikoladasm.aspark.Request;
import nikoladasm.aspark.Response;

import com.google.gson.Gson;

public class ApiService {

	private TestCaseDao dao;
	
	public ApiService(TestCaseDao dao) {
		this.dao = dao;
	}

	public Object allTestCases(Request request, Response response) {
		response.type("application/json");
		return new Gson().toJson(dao.getAllTestCases());
	}
	
	public Object testCasesRange(Request request, Response response) {
		response.type("application/json");
		return new Gson().toJson(dao.getTestCases(
				request.paramsMap(":startWith").integerValue(),
				request.paramsMap(":count").integerValue()));
	}
	
	public Object testCasesCount(Request request, Response response) {
		return dao.getTestCaseCount();
	}

	public Object addTestCase(Request request, Response response) {
		try {
			TestCase testCase = new Gson().fromJson(request.body(), TestCase.class);
			String msg = testCaseCheck(testCase);
			if (msg == null) {
				testCase.id = dao.getLastId()+1;
				try {
					dao.putTestCase(testCase);
				} catch (IllegalArgumentException e) {
					String errMsg = e.getMessage();
					response.status(406);
					return errMsg;
				}
				response.status(201);
				return testCase.id;
			} else {
				response.status(406);
				return msg;
			}
		} catch (Exception e) {
			response.status(400);
			return "";
		}
	}
	
	public Object getTestCase(Request request, Response response) {
		response.type("application/json");
		Long id = request.paramsMap(":id").longValue();
		return new Gson().toJson(dao.getTestCase(id));
	}
	
	public Object editTestCase(Request request, Response response) {
		try {
			TestCase testCase = new Gson().fromJson(request.body(), TestCase.class);
			String msg = testCaseCheck(testCase);
			if (msg == null) {
				try {
					dao.putTestCase(testCase);
				} catch (IllegalArgumentException e) {
					String errMsg = e.getMessage();
					response.status(406);
					return errMsg;
				}
				response.status(201);
				return testCase.id;
			} else {
				response.status(406);
				return msg;
			}
		} catch (Exception e) {
			response.status(400);
			return "";
		}
	}
	
	public Object deleteTestCase(Request request, Response response) {
		Long id = request.paramsMap(":id").longValue();
		dao.deleteTestCase(id);
		return id;
	}
	
	public Object getTestCaseByTitle(Request request, Response response) {
		response.type("application/json");
		String title = request.body();
		return new Gson().toJson(dao.getTestCase(title));
	}
	
	private String testCaseCheck(TestCase testCase) {
		String err = null;
		if (testCase.title.trim().isEmpty())
			err = (err == null) ? "Title can't be empty" : err;
		if (testCase.description.trim().isEmpty())
			err = (err == null) ? "Description can't be empty" : err;
		if (testCase.priority < 0 || testCase.priority > 5)
			err = (err == null) ? "Priority must be from 1 to 5" : err;
		if (testCase.location.trim().isEmpty())
			err = (err == null) ? "Location can't be empty" : err;
		if (testCase.status < 0 || testCase.status > 5)
			err = (err == null) ? "Status must be from 1 to 5" : err;
		if (testCase.steps.trim().isEmpty())
			err = (err == null) ? "Steps can't be empty" : err;
		if (testCase.expectedResults.trim().isEmpty())
			err = (err == null) ? "Expected results can't be empty" : err;
		if (testCase.assignedTo.trim().isEmpty())
			err = (err == null) ? "Assigned to can't be empty" : err;
		if (testCase.owner.trim().isEmpty())
			err = (err == null) ? "Owner to can't be empty" : err;
		if (testCase.version <= 0)
			err = (err == null) ? "Version must be greater then 0" : err;
		return err;
	}
}
