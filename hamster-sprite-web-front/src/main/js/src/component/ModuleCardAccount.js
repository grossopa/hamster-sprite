
import ModuleCard from './ModuleCard.js';
import AccountBox from 'material-ui/svg-icons/action/account-box';

class ModuleCardAccount extends ModuleCard {
  constructor() {
    super(AccountBox, 'Account', 'account');
  }
}

export default ModuleCardAccount;
