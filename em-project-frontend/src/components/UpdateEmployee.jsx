import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import EmployeeService from '../service/EmployeeService'


const UpdateEmployee = () => {
  const { id } = useParams();
    const navigate = useNavigate();
    
  const [employee,setEmployee]=useState({id:'',name:"",phone:"",email:""});
    const handleChange=(e)=>{
         const value = e.target.value;
         setEmployee({...employee,[e.target.name]:value});
     }

     useEffect(() => {
         console.log("use effect called");
         const fetchData = async () => {
           console.log("fetch data called");
           try {
      // fetch employee by id param from route
      const response = await EmployeeService.getEmployeeById(id);
      setEmployee(response.data);
           } catch (error) {
             console.error('Error fetching employee data:', error);
           }
         };
         fetchData(); 
       },[]);
   const handleUpdate=(e)=>{
     e.preventDefault();
     EmployeeService.updateEmployee(employee,id)
     .then((response)=>{
       console.log("updated",response);
       navigate('/');
     })
     .catch((error)=>{
       console.log(error);
     })
   }
     return (
     <div className='max-w-xl mx-40 bg-slate-800 my-20 rounded shadow py-4 px-8'>
         <div className="text-4xl tracking-wider font-bold text-center py-4 px-8">
             <p>Update 👨🏻‍🦰 New Employee</p>
         </div>
         <div className="mx-10 my-2">
             <input type='text'
             name='name' 
             value={employee.name}
             onChange={(e)=>handleChange(e)}
             className='w-full bg-gray-200 py-2 my-4 text-slate-800' placeholder='Name'/>
             <input type='number' 
             name='phone' 
             value={employee.phone}
             onChange={(e)=>handleChange(e)}
             className='w-full bg-gray-200 py-2 my-4 text-slate-800' placeholder='Phone'/>
             <input type='email'
             name='email' 
             value={employee.email}
             onChange={(e)=>handleChange(e)}
             className='w-full bg-gray-200 py-2 my-4 text-slate-800' placeholder='Email'/>
         </div>
         <div className="flex my-4 space-x-4 px-37">
             <button onClick={handleUpdate} className='bg-green-400 hover:bg-green-700 py-2 px-2 rounded'>Update</button>
             
             <button onClick={()=>navigate('/')}
             className='bg-red-400 hover:bg-red-700 py-2 px-2 rounded'>Cancel</button>
         </div>
         
         
     </div>
   )
}

export default UpdateEmployee;