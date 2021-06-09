import './App.css';
import Dashboard from './layouts/Dashboard';
import 'semantic-ui-css/semantic.min.css'
import Navbar from './layouts/Navbar';

function App() {
  return (
    <div className="App">
      <Navbar/>
      <Dashboard/>
    </div>
  );
}

export default App;
