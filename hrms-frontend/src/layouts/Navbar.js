import React from 'react'
import { Button, Container, Dropdown, Menu } from 'semantic-ui-react'

export default function Navbar() {
    return (
        <div>
            <Menu  inverted borderless color="teal" size='large' fixed="top">
                <Menu.Item 
                    name='LOGO'
                />
            <Menu.Item
                name='ANA SAYFA'
            />
            <Menu.Item
                name="İŞ İLANLARI"
            />
        

            <Menu.Menu  position='right'>
                <Menu.Item>
                    <Button primary>OTURUM AÇ</Button>
                </Menu.Item>

                <Menu.Item>
                    <Button primary>KAYDOL</Button>
                </Menu.Item>
            </Menu.Menu>
        </Menu>
        </div>
    )
}
