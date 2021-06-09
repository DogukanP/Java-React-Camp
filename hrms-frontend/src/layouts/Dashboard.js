import React from 'react'
import { Container, Sidebar } from 'semantic-ui-react'
import { Grid } from "semantic-ui-react"
import EmployerList from '../pages/EmployerList'
import Categories from './Categories'

export default function Dashboard() {
    return (
        <div>
            <Container className="container">
            <Grid>
        <Grid.Row>
          <Grid.Column width={4}>
            <Categories/>
          </Grid.Column>
          <Grid.Column width={12}>
            <EmployerList/>
          </Grid.Column>
        </Grid.Row>
      </Grid>
            </Container>
        </div>
    )
}
