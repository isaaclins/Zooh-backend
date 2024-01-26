import './App.css';
import ZoohCard from './components/ZoohCard';
import logo from './imgs/img1.jpg';
import ZoohNavBar from './components/ZoohNavBar';

function App() {
  return (
    <>
      <ZoohNavBar/>
    <div className="App d-flex flex-row">
      <ZoohCard text="test" image={logo}/>
      <ZoohCard text="test2" image={logo}/>
    </div>

    
    </>
  );
}

export default App;