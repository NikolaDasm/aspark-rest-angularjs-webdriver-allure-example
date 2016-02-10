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

package nikoladasm.examples.aspark_angularjs_rest;

import static java.util.concurrent.TimeUnit.*;

public abstract class Waiting {

	public static final long DEFAULT_POLLING_INTERVAL = SECONDS.toMillis(1);
	public static final long DEFAULT_TIMEOUT = SECONDS.toMillis(5);
	
	@FunctionalInterface
	public static interface Condition {
		boolean check();
	}
	
	public static void waitWhile(Condition condition, long timeout, long pollingInterval) {
		long endTime = System.currentTimeMillis()+timeout;
		while (System.currentTimeMillis()<endTime) {
			if (condition.check()) return;
			try {
				Thread.sleep(pollingInterval);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public static void waitWhile(Condition condition, long timeout) {
		waitWhile(condition, timeout, DEFAULT_POLLING_INTERVAL);
	}

	public static void waitWhile(Condition condition) {
		waitWhile(condition, DEFAULT_TIMEOUT, DEFAULT_POLLING_INTERVAL);
	}
}
