
import ModuleCard from './ModuleCard.js';
import Keyboard from 'material-ui/svg-icons/hardware/keyboard';

class ModuleCardPassword extends ModuleCard {
  constructor() {
    super(Keyboard, "Password");
  }
}

export default ModuleCardPassword;