import axios from 'axios';

const EMPLOYEE_SAPI_URL = "http://localhost:9090/employees";
class EmployeeService {
    saveEmployee(employee) {
        // Logic to save employee, e.g., an API call
        return axios.post(EMPLOYEE_SAPI_URL, employee);
    }
    getEmployee() {
        // Logic to get employees, e.g., an API call
        return axios.get(EMPLOYEE_SAPI_URL);
    }
    getEmployeeById(id) {
        // Logic to get employee by Id, e.g., an API call
        return axios.get(EMPLOYEE_SAPI_URL+"/"+id);
    }

    deleteEmployeeById(id) {
        // Logic to delete employee by Id, e.g., an API call
        return axios.delete(EMPLOYEE_SAPI_URL+"/"+id);
    }

    updateEmployee(employee,id) {
        // Logic to update employee by Id, e.g., an API call
        return axios.put(EMPLOYEE_SAPI_URL+"/"+id, employee);
    }
}
export default new EmployeeService();