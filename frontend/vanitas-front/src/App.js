import Footer from './component/Footer';
import Navbar from './component/Navbar';
import Input from './component/Input';
import Output from './component/Output';
import {createContext, useState} from "react";


export const DataContext = createContext();

function App() {
    const [data, setData] = useState({
        newDataList: [],
        urlList: []
    });

    return (
        <>
            <DataContext.Provider value={{ data, setData }}>
                <div className="d-flex flex-column" style={{minHeight: '100vh'}}>
                    <Navbar/>
                    <Input/>
                    <Output/>
                    <Footer/>
                </div>
            </DataContext.Provider>
        </>
    );
}

export default App;