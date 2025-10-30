import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useEffect } from 'react';
import EmployeeService from '../service/EmployeeService';  
const EmployeeList = () => {
  const[loading,setLoading]=useState(true); 
  const [employees,setEmployees]=useState([]);
  useEffect(() => {
    console.log("use effect called");
    const fetchData = async () => {
      console.log("fetch data called");
      setLoading(true);
      try {
        const response = await EmployeeService.getEmployee();
        // const data = await response.json();
        setEmployees(response.data);
      } catch (error) {
        console.error('Error fetching employee data:', error);
      }
      setLoading(false);
    };
    fetchData(); 
  },[]);

  const deleteEmployee = (e, id) => {
    e.preventDefault();
    EmployeeService.deleteEmployeeById(id)
            .then(()=>{
              if (employees){
                setEmployees((prevEmployees) =>
                  prevEmployees.filter((employee) => employee.id !== id)
                );
              }
               
            })
            
  };
  const navigate = useNavigate();
  const editEmployee = (e, id) => {
    e.preventDefault();
    // navigate to edit page for this employee id (use template literal)
    navigate(`/editEmployee/${id}`);
  };
  
  return (
    <div className="container mx-auto my-8">
        <div className="">
        <button onClick={()=>navigate("/addEmployee")}
         className='bg-slate-600 hover:bg-blue-700 mx-40 my-12 font-semibold p-4 rounded-2xl'>Add Employee 👨🏻‍🦰</button>
      </div>
      <div className="">
        <table className=' shadow mx-40 w-[90%] text-center'>
          <thead className='bg-slate-700 text-white'>
            <tr>
              <th className='p-6 py-3  uppercase tracking-wide'>FIRSt NAME</th>
              <th className='p-6 py-3  uppercase tracking-wide'>Phone</th>
              <th className='p-6 py-3  uppercase tracking-wide'>EMAIL ID</th>
              <th className='p-6 py-3  uppercase tracking-wide'>ACTIONS</th>
            </tr>
          </thead>
          {!loading && (
            <tbody>
                {employees.map((employee) => (
                    <tr key={employee.id} className='hover:bg-white hover:text-black'>
                      <td className='text-left px-6 py-4 whitespace-nowrap'>{employee.name}</td>
                      <td className='text-left px-6 py-4 whitespace-nowrap'>{employee.phone}</td>
                      <td className='text-left px-6 py-4 whitespace-nowrap'>{employee.email}</td>
                      <td className='text-left px-6 py-4 whitespace-nowrap space-x-2'>
                        <a onClick={(e)=>editEmployee(e,employee.id)} className='hover:text-green-500 hover:cursor-pointer'>Edit 📝</a>
                        <a onClick={(e)=>deleteEmployee(e,employee.id)} className='hover:text-red-500 hover:cursor-pointer'>Delete 🗑️</a>
                      </td>
                    </tr>
                  ))}
              </tbody>
          )}
          
        </table>
      </div>
    </div>
  )
}

export default EmployeeList